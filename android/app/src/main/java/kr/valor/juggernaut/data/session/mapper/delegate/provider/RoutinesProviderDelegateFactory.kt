package kr.valor.juggernaut.data.session.mapper.delegate.provider

import kr.valor.juggernaut.domain.session.model.Session.Progressions

interface RoutinesProviderDelegateFactory {
    fun provide(progressions: Progressions, ceilUserPreferences: Double?): RoutinesProviderDelegate
}