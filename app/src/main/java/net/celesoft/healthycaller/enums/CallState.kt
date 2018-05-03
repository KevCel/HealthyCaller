package net.celesoft.healthycaller.enums

/**
 * Created by Kevin Celejowski.
 */
enum class CallState(val state:String) {
    IDLE("IDLE"),
    RINGING("RINGING"),
    OFFHOOK("OFHOOK"),
    UNKNOWN("UNKNOWN");

companion object {

    fun getCallState(state: String): CallState {
        return when(state){
            OFFHOOK.state -> OFFHOOK
            RINGING.state -> RINGING
            IDLE.state -> IDLE
            else -> UNKNOWN
        }
    }
}
}