package com.example.dagger.ui.second

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.dagger.App
import com.example.dagger.databinding.FragmentSecondBinding
import javax.inject.Inject

class SecondFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: SecondViewModelFactory

    private lateinit var binding: FragmentSecondBinding

    private val viewModel: SecondViewModel by viewModels { viewModelFactory }

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
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getChuck()
        viewModel.chuck.observe(viewLifecycleOwner) {
            Glide.with(requireContext())
                .load(it.icon_url)
                .into(binding.secondImage)
            binding.textView.text = it.value
        }
    }
}