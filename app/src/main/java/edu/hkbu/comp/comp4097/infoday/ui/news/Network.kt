package edu.hkbu.comp.comp4097.infoday.ui.news

import java.net.HttpURLConnection
import java.net.URL

class Network {
    companion object {
        suspend fun getTextFromNetwork(url: String) : String {
            val builder = StringBuilder()
            val connection =
                URL(url).openConnection() as HttpURLConnection
            var data: Int = connection.inputStream.read()
            while (data != -1) {
                builder.append(data.toChar())
                data = connection.inputStream.read()
            }
            return builder.toString()
        }
    }
}
