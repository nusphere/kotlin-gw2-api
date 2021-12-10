fun main(args: Array<String>) {

    // Set your token as parameter or var
    println(args[0])

    val gw2Api = guildwars2.Api(args[0])

    println("${gw2Api.WvW().getApiTypes()}")
}