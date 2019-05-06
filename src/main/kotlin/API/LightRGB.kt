package com.perry.API

data class LightRGB(var R: Double, var G: Double, var B: Double, var time: String) {
    fun formatColor() = "r=${this.R};g=${this.G};b=${this.B}"
}