package com.rcl.uikit

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

class Icons {
    val dotMenu: ImageVector
        get() {
            if (_dotMenu != null) {
                return _dotMenu!!
            }
            _dotMenu = Builder(name = "Vector", defaultWidth = 4.0.dp, defaultHeight = 17.0.dp,
                viewportWidth = 4.0f, viewportHeight = 17.0f).apply {
                path(fill = SolidColor(Color(0xFF1D1D1D)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                    moveTo(2.0f, 4.5f)
                    curveTo(3.1f, 4.5f, 4.0f, 3.6f, 4.0f, 2.5f)
                    curveTo(4.0f, 1.4f, 3.1f, 0.5f, 2.0f, 0.5f)
                    curveTo(0.9f, 0.5f, 0.0f, 1.4f, 0.0f, 2.5f)
                    curveTo(0.0f, 3.6f, 0.9f, 4.5f, 2.0f, 4.5f)
                    close()
                    moveTo(2.0f, 6.5f)
                    curveTo(0.9f, 6.5f, 0.0f, 7.4f, 0.0f, 8.5f)
                    curveTo(0.0f, 9.6f, 0.9f, 10.5f, 2.0f, 10.5f)
                    curveTo(3.1f, 10.5f, 4.0f, 9.6f, 4.0f, 8.5f)
                    curveTo(4.0f, 7.4f, 3.1f, 6.5f, 2.0f, 6.5f)
                    close()
                    moveTo(2.0f, 12.5f)
                    curveTo(0.9f, 12.5f, 0.0f, 13.4f, 0.0f, 14.5f)
                    curveTo(0.0f, 15.6f, 0.9f, 16.5f, 2.0f, 16.5f)
                    curveTo(3.1f, 16.5f, 4.0f, 15.6f, 4.0f, 14.5f)
                    curveTo(4.0f, 13.4f, 3.1f, 12.5f, 2.0f, 12.5f)
                    close()
                }
            }
                .build()
            return _dotMenu!!
        }

    private var _dotMenu: ImageVector? = null
}