package cc.ikt.storage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cc.ikt.storage.components.item.FileItem
import cc.ikt.storage.components.item.FileItemData
import cc.ikt.storage.data.FileType
import cc.ikt.storage.ui.theme.StorageAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StorageAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val itemList = listOf(
                        FileItemData(
                            type = FileType.FOLDER,
                            fileName = "文本1",
                            fileSize = "文本2",
                            modifyTime = "文本3"
                        ),
                        FileItemData(
                            type = FileType.IMAGE,
                            fileName = "文本4",
                            fileSize = "文本5",
                            modifyTime = "文本6"
                        ),
                    )
                    LazyColumn {
                        items(itemList) { item ->
                            when (item.type) {
                                FileType.FOLDER -> {
                                }

                                else -> {
                                }
                            }
                            FileItem(
                                bitmap = item.getIconPainter(),
                                fileName = item.fileName,
                                fileSize = item.fileSize,
                                modifyTime = item.modifyTime,
                                buttonText = "下载",
                                onButtonClick = { /* 执行点击按钮时的操作 */ }
                            )
                            Divider(Modifier.height(1.dp))
                        }
                    }
                }
            }
        }
    }
}
