package com.laksamana.birthdaycardlaksamanapt3


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.laksamana.birthdaycardlaksamanapt3.ui.theme.BirthdayCardLaksamanaPT3Theme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.Image

//TODO: Activity utama
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardLaksamanaPT3Theme {
                Surface( //TODO: Background default
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImg( //TODO: Berisi teks didepan gambar,yang telah diekstrak sebagai value string di Resources
                        message = getString(R.string.teks_selamat),
                        from = getString(R.string.nama),
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}
//TODO: Pengaturan arrangement/penempatan teks(tengah), ukuran font, pemanggilan teks dari resources, padding teks, serta tinggi baris
@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text( //TODO: Pengaturan teks selamat ulang tahun
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text( //TODO: Pengaturan teks nama pengirim, dengan penempatan di end/kanan bawah
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}
//TODO: Fungsi yang berisi box/kotak untuk penempatan gambar dan teks
@Composable
fun GreetingImg(message: String, from: String, modifier: Modifier = Modifier) {
    Box(modifier) {
        Image(
            painter = painterResource(id = R.drawable.androidparty), //TODO: Memanggil gambar yang telah didownload dan diimport ke resources
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText( //TODO: Memanggil fungsi GreetingText untuk menunjukkan teks didepan gambar
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}
//TODO: Untuk menunjukkan preview kartu ucapan di android studio
@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    BirthdayCardLaksamanaPT3Theme {
        GreetingImg(
            stringResource(R.string.teks_selamat),
            stringResource(R.string.nama)
        )
    }
}