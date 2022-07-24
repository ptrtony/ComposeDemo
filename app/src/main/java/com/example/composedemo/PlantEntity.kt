package com.example.composedemo

data class  PlantEntity(val id:String,val name:String,val description:String){
    companion object{
        var loading = PlantEntity("id","name","description")
    }
}