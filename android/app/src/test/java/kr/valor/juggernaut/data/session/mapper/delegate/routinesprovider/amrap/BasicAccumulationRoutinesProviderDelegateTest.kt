package kr.valor.juggernaut.data.session.mapper.delegate.routinesprovider.amrap

import kr.valor.juggernaut.data.session.mapper.delegate.property.DefaultPropertyMediateDelegate
import kr.valor.juggernaut.data.session.mapper.delegate.routinesprovider.PhaseEntireRoutineIntensityTable
import kr.valor.juggernaut.data.session.mapper.delegate.routinesprovider.RoutinesProviderDelegate
import kr.valor.juggernaut.data.session.mapper.delegate.routinesprovider.`validate AMRAP routines that were generated by delegate`
import org.junit.Before
import org.junit.Test

class BasicAccumulationRoutinesProviderDelegateTest {

    private lateinit var targetProviderDelegate: AMRAPRoutinesProviderDelegate
    private lateinit var table: PhaseEntireRoutineIntensityTable
    private val action = DefaultPropertyMediateDelegate::mediate

    @Before
    fun `init`() {
        targetProviderDelegate =
            BasicAccumulationRoutinesProviderDelegate(
                DefaultPropertyMediateDelegate
            )
        table = BasicAccumulationRoutinesProviderDelegate
            .entireRoutineIntensityTable
    }

    @Test
    fun `BasicAccumulationRoutinesProviderDelegate generates routines as expected`() {
        targetProviderDelegate.`validate AMRAP routines that were generated by delegate`(table, action)
    }
}