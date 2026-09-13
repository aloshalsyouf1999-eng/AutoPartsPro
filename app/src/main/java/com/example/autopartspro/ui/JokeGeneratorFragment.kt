package com.example.autopartspro.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.autopartspro.R
import com.example.autopartspro.viewmodel.JokeViewModel

class JokeGeneratorFragment : Fragment() {
    
    private val viewModel: JokeViewModel by viewModels()
    
    private lateinit var setupTextView: TextView
    private lateinit var punchlineTextView: TextView
    private lateinit var generateButton: Button
    private lateinit var loadingProgressBar: ProgressBar
    private lateinit var errorTextView: TextView
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_joke_generator, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupTextView = view.findViewById(R.id.setup_text)
        punchlineTextView = view.findViewById(R.id.punchline_text)
        generateButton = view.findViewById(R.id.generate_button)
        loadingProgressBar = view.findViewById(R.id.loading_progress)
        errorTextView = view.findViewById(R.id.error_text)
        
        generateButton.setOnClickListener {
            viewModel.fetchJoke()
        }
        
        observeViewModel()
        
        // Load initial joke
        viewModel.fetchJoke()
    }
    
    private fun observeViewModel() {
        viewModel.joke.observe(viewLifecycleOwner) { joke ->
            setupTextView.text = joke.setup
            punchlineTextView.text = joke.punchline
            errorTextView.text = ""
        }
        
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            loadingProgressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            generateButton.isEnabled = !isLoading
        }
        
        viewModel.error.observe(viewLifecycleOwner) { error ->
            if (error != null) {
                errorTextView.text = "Error: $error"
            }
        }
    }
}
