package com.example.myapplication.presentation

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.load
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val url = "https://avatars.githubusercontent.com/u/129613727?v=4"
    private val badURL = "https://TochnoNetKartinki.net/"
    @Composable
    private fun ProfileImage() {
        SubcomposeAsyncImage(
            model = url,
            contentDescription = null,
            onError = { Log.v("ERROR IMAGE","Error image load")}
        )
        SubcomposeAsyncImage(
            model = badURL,
            contentDescription = null,
            onError = { Log.v("ERROR IMAGE","Error image load")}
        )
    }
    private val path = "https://static.wikia.nocookie.net/85b98307-c993-438a-91a4-f9f03e9485b8/scale-to-width/755"
    private val badPath = "NONE"
    @Composable
    private fun LoadGlide(){
        AsyncImage(model = path,
            contentDescription =  "loadImage")
        AsyncImage(model = badPath,
            contentDescription =  "loadImage",
            onError = {Log.v("ERROR GLIDE","Error load GlideImage")})
    }

    //for xml
//    override fun onStart() {
//        super.onStart()
//        val image = findViewById<ImageView>(R.id.image)
//
//        lifecycleScope.launch {
//            viewModel.state.collect {
//                it?.image?.let { url ->
//                    image.load(url) {
//                        error(ColorDrawable(Color.RED))
//                    }
//                }
//            }
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContent {
            MyApplicationTheme {
                ProfileImage()
                LoadGlide()
            }
        }
    }

}