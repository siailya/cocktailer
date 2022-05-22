package com.overcreated.cocktailer.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.overcreated.cocktailer.components.CocktailCard
import com.overcreated.cocktailer.components.CocktailViewer
import com.overcreated.cocktailer.data.Cocktail
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun CocktailsScreen() {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()
    val selectedCocktail: MutableState<Cocktail> = remember {
        mutableStateOf(
            Cocktail(
                "",
                listOf(listOf("")),
                0f,
                0f,
                "",
                "",
                "",
                "",
                "",
                listOf("")
            )
        )
    }

    fun onCocktailClick(cocktail: Cocktail) {

        coroutineScope.launch {
            if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                selectedCocktail.value = cocktail
                bottomSheetScaffoldState.bottomSheetState.expand()
            } else {
                bottomSheetScaffoldState.bottomSheetState.collapse()
            }
        }
    }

    val jsonString =
        LocalContext.current.assets.open("cocktails.json").bufferedReader().use { it.readText() }
    val cocktails = Json.decodeFromString<List<Cocktail>>(jsonString)


    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetElevation = 20.dp,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetContent = {
            CocktailViewer(cocktail = selectedCocktail.value)
        },
        sheetPeekHeight = 0.dp,
        drawerScrimColor = Color(0x59000000)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
                .padding(bottom = 56.dp)
        ) {
            items(cocktails.size) { index ->
                CocktailCard(cocktails[index], onClick = { cocktail -> onCocktailClick(cocktail) })
            }
        }
    }
}