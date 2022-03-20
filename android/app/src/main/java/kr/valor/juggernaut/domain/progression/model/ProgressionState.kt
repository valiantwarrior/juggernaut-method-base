package kr.valor.juggernaut.domain.progression.model

import kr.valor.juggernaut.common.*
import kr.valor.juggernaut.data.session.entity.SessionEntity
import kr.valor.juggernaut.domain.session.model.Progression

sealed class ProgressionState {
    object None: ProgressionState()
    data class OnGoing(val currentUserProgression: UserProgression): ProgressionState()
    data class Done(val latestUserProgression: UserProgression): ProgressionState()
}

data class UserProgression(
    val methodCycle: MethodCycle,
    val phase: Phase,
    val microCycle: MicroCycle
) {

    val serializedValue: Triple<Int, String, String>
        get() = Triple(methodCycle.value, phase.name, microCycle.name)

    fun toSessionProgression() = Progression(
        methodCycle, phase, microCycle
    )

}