package com.ahmed.sharelogger.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.ahmed.sharelogger.R;

import com.ahmed.sharelogger.databinding.FragmentHomeBinding;
import com.ahmed.sharelogger.utils.SettingsManager;

import java.util.Set;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private Switch buttonEnableService;
    private SettingsManager settingsManagerInstance;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textHome;
        //homeViewModel.getmText().observe(getViewLifecycleOwner(), textView::setText);
        settingsManagerInstance = SettingsManager.getInstance(getActivity());
        // service switch
        buttonEnableService = (Switch) root.findViewById(R.id.buttonEnableService);
        buttonEnableService.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                settingsManagerInstance.setClipboardMonitorServiceEnabled(isChecked);
            }
        });

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}