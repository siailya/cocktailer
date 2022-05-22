package com.overcreated.cocktailer.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.overcreated.cocktailer.R
import com.overcreated.cocktailer.data.Cocktail
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CocktailViewer(cocktail: Cocktail) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(800.dp)
            .padding(start = 8.dp, end = 8.dp, bottom = 56.dp)
            .verticalScroll(scrollState)
    ) {
//        region Header
        Text(
            text = cocktail.name,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = cocktail.commonName,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Light
        )
//        endregion

//        region Image
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(top = 12.dp)
                .clip(RoundedCornerShape(10.dp))
        ) {
            GlideImage(
                imageModel = cocktail.image,
                contentScale = ContentScale.Crop,
                placeHolder = ImageBitmap.imageResource(R.drawable.placeholder),
                error = ImageBitmap.imageResource(R.drawable.error)
            )
        }
//        endregion

//        region Description
        Text(
            text = cocktail.fullDescription,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
        )
//        endregion

//        region Ingredients
        Headline(text = "Ингредиенты")
        LazyRow(modifier = Modifier.padding(top = 20.dp)) {
            items(cocktail.ingredients) { ingredient ->
                Surface(
                    elevation = 5.dp,
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colors.secondaryVariant,
                    modifier = Modifier.padding(end = 12.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(6.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = ingredient[0],
                            textAlign = TextAlign.Center
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = ingredient.getOrElse(1, { "" }),
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
//        endregion

//        region Receipt
        Headline(text = "Как приготовить")
        Column(modifier = Modifier.padding(top = 20.dp, bottom = 12.dp)) {
            cocktail.receipt.forEachIndexed { index, step ->
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(.075f)
                            .aspectRatio(1f)
                            .clip(CircleShape)
                            .background(MaterialTheme.colors.primary),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = (index + 1).toString(),
                            color = Color.White
                        )
                    }
                    Text(
                        text = step,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
//        endregion
    }
}