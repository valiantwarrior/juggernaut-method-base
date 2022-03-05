package kr.valor.juggernaut.data.session.mapper.delegate.routinesprovider

import kr.valor.juggernaut.common.*
import kr.valor.juggernaut.domain.session.model.Routine
import kr.valor.juggernaut.domain.session.model.SessionRoutine

interface RoutinesProviderDelegate {
    fun provideRoutines(phase: Phase, tmWeights: Double): SessionRoutine
}

abstract class BasicMethodRoutinesProviderDelegate: RoutinesProviderDelegate {
    protected abstract val routinesPropertyMediateAction: (Double) -> Double

    abstract override fun provideRoutines(phase: Phase, tmWeights: Double): SessionRoutine

    protected inline fun List<RoutineIntensity>.createRoutine(tmWeights: Double, transform: (Double) -> Double) =
        map { it.createRoutine(tmWeights, transform) }

    protected inline fun RoutineIntensity.createRoutine(tmWeights: Double, transform: (Double) -> Double) =
        Routine(
            weights = transform(tmWeights * intensityPercentage),
            reps = repetitions
        )

    protected fun PhaseRoutineIntensityItem.toRoutineIntensityModel() =
        RoutineIntensity(first, second)

    protected fun List<PhaseRoutineIntensityItem>.toRoutineIntensityModel() =
        map { it.toRoutineIntensityModel() }


    protected data class RoutineIntensity(
        val repetitions: Int,
        val intensityPercentage: Double
    )
}