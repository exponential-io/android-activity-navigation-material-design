package io.exponential.mdnavigation;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class MainFragment extends Fragment {
    private static final String ARG_INPUT_FROM_ACTIVITY = "MainFragment.ARG_INPUT_FROM_ACTIVITY";
    private String inputFromActivity;

    private Callbacks callbacks;

    /**
     * Factory method to create a new instance of MainFragment.
     *
     * @param inputFromActivity Parameter passed in from Activity when creating an instance.
     * @return A new instance of fragment MainFragment.
     */
    public static MainFragment newInstance(String inputFromActivity) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_INPUT_FROM_ACTIVITY, inputFromActivity);
        fragment.setArguments(args);
        return fragment;
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            inputFromActivity = getArguments().getString(ARG_INPUT_FROM_ACTIVITY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        // Read how final is used to allow access to context within the anonymous inner class below.
        // ref: http://en.wikipedia.org/wiki/Final_%28Java%29 (read the Final and inner classes
        // section)
        final Context context = getActivity();

        // Floating Action Button (FAB)
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar
                        .make(v, "Placeholder", Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(context, "Undo clicked", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
                }
            });
        }

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callbacks = (Callbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement Callbacks");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }

    public interface Callbacks {
        public void passDataToActivity(String data);
    }

}
