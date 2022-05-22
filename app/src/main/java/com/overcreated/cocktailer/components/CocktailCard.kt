package com.overcreated.cocktailer.components

import android.util.Log
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ssjetpackcomposeswipeableview.SwipeAbleItemView
import com.example.ssjetpackcomposeswipeableview.SwipeDirection
import com.overcreated.cocktailer.R
import com.overcreated.cocktailer.data.Cocktail
import com.skydoves.landscapist.glide.GlideImage
import kotlin.math.roundToInt


@ExperimentalMaterialApi
@Composable
fun CocktailCard(
    cocktail: Cocktail,
    onClick: (Cocktail) -> Unit
) {
    Box(modifier = Modifier.padding(vertical = 6.dp)) {
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
            leftViewBackgroundColor = MaterialTheme.colors.primary,
            rightViewBackgroundColor = MaterialTheme.colors.primary
        ) {
            Surface(
                elevation = 15.dp,
                shape = RoundedCornerShape(10.dp),
                color = MaterialTheme.colors.secondaryVariant,
                modifier = Modifier.clickable { onClick(cocktail) }
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
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
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
                                .padding(top = 8.dp),
                        )
                        Text(
                            text = "~" + cocktail.foodCost.roundToInt().toString() + "₽",
                            fontSize = 18.sp,
                            textAlign = TextAlign.Right,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }

}