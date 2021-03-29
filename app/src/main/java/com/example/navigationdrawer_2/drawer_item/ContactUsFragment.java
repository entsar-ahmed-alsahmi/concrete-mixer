package com.example.navigationdrawer_2.drawer_item;


import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.navigationdrawer_2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUsFragment extends Fragment {


    public ContactUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_contact_us, container, false);

        Button callAhmed =view.findViewById(R.id.callAhmed);
        Button callAbdo =view.findViewById(R.id.callAbdulqader);
        Button callZeyad =view.findViewById(R.id.callZeyad);
        Button callOmar =view.findViewById(R.id.callOmar);
        Button callYaseen =view.findViewById(R.id.callYaseen);
        Button callRoyda =view.findViewById(R.id.callRoyda);

        Button facAhmed =view.findViewById(R.id.facebookAhmed);
        Button faclAbdo =view.findViewById(R.id.facebookAbdulqader);
        Button facZeyad =view.findViewById(R.id.facebookZeyad);
        Button facOmar =view.findViewById(R.id.facebookOmar);
        Button facYaseen =view.findViewById(R.id.facebookYaseen);
        Button facRoyda =view.findViewById(R.id.facebookRoyda);

        callAhmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+967774857999"));
                    startActivity(intent);
            }
        });
        callAbdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+967773791000"));
                startActivity(intent);
            }
        });
        callZeyad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+967770081939"));
                startActivity(intent);
            }
        });

        callOmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+967777888033"));
                startActivity(intent);
            }
        });

        callYaseen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+967770681883"));
                startActivity(intent);
            }
        });

        callRoyda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+967776406524"));
                startActivity(intent);
            }
        });

        facAhmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://192.168.191.1/finalPro2/finalPro/tailwindcss-playground/public/action.php"));
                startActivity(intent);
            }
        });

        faclAbdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100003494998781"));
                startActivity(intent);
            }
        });
        facOmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/EngOmarkhalil97"));
                startActivity(intent);
            }
        });

        facZeyad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ziad.alariki.5"));
                startActivity(intent);
            }
        });

        facYaseen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/yasenshibane/"));
                startActivity(intent);
            }
        });
        return view;
    }

}
