package com.example.thanksgivingdinner

data class Dessert(var name: String = "", var url: String="") {
    fun suggestDessert(position:Int){
        setDessertName(position)
        setDessertUrl(position)
    }

    private fun setDessertName(position: Int){
        when(position){
            0 -> name="Apple Pie"
            1 -> name="Pumpkin Pie"
            2 -> name="Pecan Pie"
            else -> name="pie of your choice"

        }
    }

    private fun setDessertUrl(position: Int){
        when(position){
            0 -> url="https://www.allrecipes.com/recipe/12682/apple-pie-by-grandma-ople/"
            1 -> url="https://www.allrecipes.com/recipe/230132/chef-johns-pumpkin-pie/"
            2 -> url="https://www.allrecipes.com/recipe/9487/pecan-pie/"
            else -> name="https://www.google.com/search?q=pie+recipe"

        }
    }

}