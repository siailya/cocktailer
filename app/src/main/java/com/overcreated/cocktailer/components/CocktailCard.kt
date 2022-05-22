package com.overcreated.cocktailer.components

import android.content.res.Resources
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ssjetpackcomposeswipeableview.SwipeAbleItemView
import com.example.ssjetpackcomposeswipeableview.SwipeDirection
import com.overcreated.cocktailer.R
import com.overcreated.cocktailer.data.Cocktail
import com.overcreated.cocktailer.data.Ingredient
import com.overcreated.cocktailer.data.PreparedIngredient
import com.overcreated.cocktailer.ui.theme.AccentRedLight
import com.skydoves.landscapist.glide.GlideImage

val testIngredient = PreparedIngredient(
    Ingredient("Водка", "Водка и водка...", 500f, 40f, true),
    1f
)
val testCocktail = Cocktail(
    "Секс на пляже",
    listOf(testIngredient),
    40f,
    500f,
    "Классифицируется как лонг дринк. Входит в число официальных коктейлей Международной ассоциации барменов (IBA), категория «Современная классика»",
    "Sex on the beach",
    "https://upload.wikimedia.org/wikipedia/commons/5/5a/Sex_on_the_Beach.jpg"
)

@ExperimentalMaterialApi
@Preview
@Composable
fun CocktailCard(cocktail: Cocktail = testCocktail) {
    SwipeAbleItemView(
        height = 200.dp,
        leftViewIcons = arrayListOf(
            Triple(
                rememberVectorPainter(image = Icons.Rounded.Star),
                Color.White,
                "btnDeleteLeft"
            )
        ),
        rightViewIcons = arrayListOf(
            Triple(
                (rememberVectorPainter(image = Icons.Rounded.Star)),
                Color.White,
                "btnDeleteRight"
            )
        ),
        onClick = {
            Log.v("123", "123")
        },
        cornerRadius = 10.dp,
        rightSpace = 12.dp,
        swipeDirection = SwipeDirection.LEFT,
        leftViewBackgroundColor = AccentRedLight,
        rightViewBackgroundColor = AccentRedLight
    ) {
        Surface(
            elevation = 15.dp,
            shape = RoundedCornerShape(10.dp),
            color = MaterialTheme.colors.background,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth(.5f)) {
                    GlideImage(
                        imageModel = cocktail.image,
                        contentScale = ContentScale.Crop,
                        placeHolder = ImageBitmap.imageResource(R.drawable.placeholder),
                        error = ImageBitmap.imageResource(R.drawable.error)
                    )
                }
                Column(
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = cocktail.name,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = cocktail.commonName,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Italic
                    )
                    Text(
                        text = cocktail.description,
                        fontSize = 13.sp,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                    )
                }
            }
        }
    }
}