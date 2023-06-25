package com.example.dagger.ui.first

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.dagger.App
import com.example.dagger.databinding.FragmentFirstBinding
import javax.inject.Inject

class FirstFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: FirstViewModelFactory

    private lateinit var binding: FragmentFirstBinding

    private val viewModel: FirstViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.applicationComponent?.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState:
        Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getDog()
        viewModel.dog.observe(viewLifecycleOwner) {
            Glide.with(requireContext())
                .load(it)
                .into(binding.firstImage)
        }
    }
}