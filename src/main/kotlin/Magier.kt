
class Mage(name: String, hp: Int): Hero(name, hp, hp) {
    var actionDamage = 50
    var healAmount = 20

    override fun performAction(action: String, target: Enemy) {
        isProtected = false
        when (action) {
            "ZauberSturm" -> target.takeDamage(actionDamage)
            "TodesZauber" ->{
                target.takeDamage(200)

            }
            "HeilZauber" -> this.heal(healAmount)
            "ZauberSchild"->{
                println("$name nutzt den Schutzzauber.")
                isProtected = true
            }
            else -> super.performAction(action, target)
        }
    }
    override fun getActionNames(): List<String> {
        return listOf("ZauberSturm","TodesZauber","HeilZauber","ZauberSchild")
    }
    override fun increaseVitality(percent:Int){
        actionDamage += (actionDamage/100*percent).toInt()
    }
}