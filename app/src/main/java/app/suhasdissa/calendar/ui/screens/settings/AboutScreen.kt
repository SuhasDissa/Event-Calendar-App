package app.suhasdissa.calendar.ui.screens.settings

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import app.suhasdissa.calendar.backend.viewmodels.CheckUpdateViewModel
import app.suhasdissa.calendar.ui.components.SettingItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
    updateViewModel: CheckUpdateViewModel = viewModel(factory = CheckUpdateViewModel.Factory)
) {
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    "About",
                    color = MaterialTheme.colorScheme.primary
                )
            })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                SettingItem(
                    title = "Website Link",
                    description = "Open the Ceylon Event Calendar webstie",
                    onClick = { openBrowser(context, "https://ceylon-event-cal.onrender.com/") },
                    icon = Icons.Default.Description
                )
            }
            item {
                SettingItem(
                    title = "App Version",
                    description = "${updateViewModel.currentVersion}",
                    onClick = {},
                    icon = Icons.Default.Info
                )
            }
        }
    }
}

fun openBrowser(context: Context, url: String) {
    val viewIntent: Intent = Intent().apply {
        action = Intent.ACTION_VIEW
        data = Uri.parse(url)
    }
    context.startActivity(viewIntent)
}
