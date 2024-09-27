import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RoundedButton(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    buttonColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
    iconSize: Int = 48 // Novo parâmetro para definir o tamanho do ícone
) {
    Column(
        modifier = modifier
            .width(115.dp),  // Largura do botão quadrado
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Alterando o shape para RoundedCornerShape para cantos arredondados
        Button(
            onClick = onClick,
            shape = RoundedCornerShape(12.dp),  // Forma quadrada com cantos arredondados
            colors = ButtonDefaults.buttonColors(
                containerColor = buttonColor,
                contentColor = contentColor
            ),
            modifier = Modifier
                .size(118.dp) // Aumentando o tamanho do botão quadrado
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(icon, contentDescription = null, tint = Color.White,
                    modifier = Modifier.size(iconSize.dp)
                ) // ícone
                Spacer(modifier = Modifier.height(8.dp))
                Text(text, color = Color.White, textAlign = TextAlign.Center, fontSize = 14.sp, style = TextStyle.Default.copy(
                    lineBreak = LineBreak.Simple
                ), modifier = Modifier.fillMaxWidth()) // texto
            }
        }
        Spacer(modifier = Modifier.height(8.dp))

    }
}
