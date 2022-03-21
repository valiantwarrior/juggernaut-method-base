package kr.valor.juggernaut.ui.session.preview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.valor.juggernaut.databinding.FragmentPreviewBinding
import kr.valor.juggernaut.ui.NavigationFragment
import kr.valor.juggernaut.ui.observeFlowEvent

@AndroidEntryPoint
class PreviewFragment : NavigationFragment() {

    private val previewViewModel: PreviewViewModel by viewModels()

    private lateinit var binding: FragmentPreviewBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPreviewBinding.inflate(inflater, container, false)
            .apply {
                viewModel = previewViewModel
                lifecycleOwner = viewLifecycleOwner
            }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initEventObserver()
    }

    private fun initEventObserver() {
        observeFlowEvent(previewViewModel.uiEventFlow) { event ->
            when(event) {
                is PreviewUiEvent.StartSession -> {
                    navigate(PreviewFragmentDirections.actionPreviewDestToRecordFragment(event.sessionId))
                }
                PreviewUiEvent.Back -> {
                    navigate(PreviewFragmentDirections.actionPreviewDestToHomeDest())
                }
            }
        }
    }

}