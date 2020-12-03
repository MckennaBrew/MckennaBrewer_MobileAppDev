package com.example.tarotreader

data class Cards(var readType: Int =  0, var readTopic: Int = 0) {

    fun suggestCards(type: String, topic: String){
        setReadingType(type)
        setReadingTopic(topic)
    }

    private fun setReadingType(type: String) {
       // readType = type

        when(type){
            "1 card" -> readType = 1  // 1 card read
            "2 card" -> readType = 2  // 2 card read
            "3 card" -> readType = 3  // 3 card read

        }
    }

    private fun setReadingTopic(topic: String) {
        // readTopic = topic

        when(topic){
            "Love" -> readTopic = 1 // Love topic
            "Career" -> readTopic = 2 // Career topic
            "Daily" -> readTopic = 3 // Daily topic
        }
    }

}