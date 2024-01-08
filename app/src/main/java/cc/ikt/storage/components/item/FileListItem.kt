package cc.ikt.storage.components.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cc.ikt.storage.R
import cc.ikt.storage.data.FileType

data class FileItemData(
    val type: FileType,
    val fileName: String,
    val fileSize: String,
    val modifyTime: String
) {
    @Composable
    fun getIconPainter(): Painter {

        return when (type) {
            FileType.FOLDER -> {
                painterResource(id = R.mipmap.ic_folder) // 使用资源 ID 创建 Painter
            }

            FileType.IMAGE -> {
                painterResource(id = R.mipmap.ic_file_image)
            }

            FileType.AUDIO -> {
                painterResource(id = R.mipmap.ic_file_audio)
            }

            FileType.VIDEO -> {
                painterResource(id = R.mipmap.ic_file_video)
            }

            else -> {
                painterResource(id = R.mipmap.ic_file_unknown)
            }
        }
    }
}


@Composable
fun FileItem(
    modifier: Modifier = Modifier,
    bitmap: Painter,
    fileName: String,
    fileSize: String,
    modifyTime: String,
    buttonText: String,
    onButtonClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable { /* 你的点击逻辑 */ }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = bitmap,
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .background(color = Color.Transparent)
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            ) {
                Text(text = fileName)
                Text(text = fileSize)
                Text(text = modifyTime)
            }
        }

        Button(
            onClick = onButtonClick,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 8.dp)
        ) {
            Text(text = buttonText)
        }
    }
}
