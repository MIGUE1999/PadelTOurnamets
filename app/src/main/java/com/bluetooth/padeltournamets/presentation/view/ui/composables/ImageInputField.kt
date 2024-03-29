package com.bluetooth.padeltournamets.presentation.view.ui.composables

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.bluetooth.padeltournamets.presentation.viewmodel.TournamentViewModel

@Composable
fun PickImageFromGallery(tournamentViewModel : TournamentViewModel) {

    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current
    val bitmap = remember{ mutableStateOf<Bitmap?>(null)}

    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
            imageUri = uri
        }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        imageUri?.let {
            if (Build.VERSION.SDK_INT < 28) {
                bitmap.value = MediaStore.Images
                    .Media.getBitmap(context.contentResolver, it)
                tournamentViewModel.onCartelChanged(bitmap.value!!)
                Log.d("Debuggingif", imageUri.toString())

            } else {
                val source = ImageDecoder.createSource(context.contentResolver, it)
                bitmap.value = ImageDecoder.decodeBitmap(source)
                tournamentViewModel.onCartelChanged(bitmap.value!!)
                Log.d("Debuggingelse", imageUri.toString())
            }
        }

            tournamentViewModel.cartel.value?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(300.dp)
                        .padding(0.dp)
                )
            }


        }

        Button(onClick = { launcher.launch("image/*") }, colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = Color.DarkGray)) {
            Text(text = "Cartel del Torneo")
        }
}