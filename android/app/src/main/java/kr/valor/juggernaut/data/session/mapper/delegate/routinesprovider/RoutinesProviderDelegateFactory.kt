package kr.valor.juggernaut.data.session.mapper.delegate.routinesprovider

import kr.valor.juggernaut.domain.session.model.AmrapSession.Progressions

interface RoutinesProviderDelegateFactory {
    fun provide(progressions: Progressions, ceilUserPreferences: Double?): BasicMethodRoutinesProviderDelegate
}