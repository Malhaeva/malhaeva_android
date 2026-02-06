package com.corkcharge.myapplication.malhaeva_android.ui.settings.component


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.corkcharge.myapplication.malhaeva_android.ui.theme.Gray50
import com.corkcharge.myapplication.malhaeva_android.ui.theme.Malhaeva_androidTheme

@Composable
fun SettingsItem(
    title: String,
    hasSwitch: Boolean = false,
    isDestructive: Boolean = false,
    onClick: () -> Unit = {}
) {
    var checked by remember { mutableStateOf(true) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            color = if (isDestructive) Color.Red else Color.Black,
            fontSize = 16.sp
        )
        if (hasSwitch) {
            Switch(checked = checked, onCheckedChange = { checked = it }, modifier = Modifier.height(20.dp))
        } else {
            Icon(
                Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                tint = Color.LightGray,
                modifier = Modifier.size(16.dp)
            )
        }
    }
    HorizontalDivider(color = Gray50, thickness = 1.dp)
}

@Preview(showBackground = true)
@Composable
fun SettingsItemPreview() {
    Malhaeva_androidTheme {
        SettingsItem(title = "Account")
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsItemWithSwitchPreview() {
    Malhaeva_androidTheme {
        SettingsItem(title = "Notifications", hasSwitch = true)
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsItemDestructivePreview() {
    Malhaeva_androidTheme {
        SettingsItem(title = "Delete Account", isDestructive = true)
    }
}