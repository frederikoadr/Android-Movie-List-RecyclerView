package com.adrian.recyclerview;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    private RecyclerView rvHeroes;
    private ArrayList<Hero> list = new ArrayList<>();

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvHeroes = (RecyclerView) getView().findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);

        list.addAll(getListHeroes());
        showRecyclerList();
    }

    public ArrayList<Hero> getListHeroes() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        String[] dataPhoto = getResources().getStringArray(R.array.data_photo);
        String[] dataMainDesc = getResources().getStringArray(R.array.data_main_desc);
        String[] dataImdb = getResources().getStringArray(R.array.data_imdb);
        String[] dataStoryline = getResources().getStringArray(R.array.data_storyline);
        ArrayList<Hero> listHero = new ArrayList<>();
        for (int i = 10; i < dataName.length; i++) {
            Hero hero = new Hero();
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            hero.setPhoto(dataPhoto[i]);
            hero.setMainDesc(dataMainDesc[i]);
            hero.setImdb(dataImdb[i]);
            hero.setStoryline(dataStoryline[i]);
            listHero.add(hero);
        }
        return listHero;
    }

    private void showSelectedHero(Hero hero) {
        //Toast.makeText(getActivity(), "Kamu memilih " + hero.getName(), Toast.LENGTH_SHORT).show();
        Intent moveWithObjectIntent = new Intent(getActivity(), DetailActivity.class);
        moveWithObjectIntent.putExtra(DetailActivity.EXTRA_PERSON, hero);
        startActivity(moveWithObjectIntent);
    }

    private void showRecyclerList(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(getActivity()));
        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(list);
        rvHeroes.setAdapter(listHeroAdapter);

        listHeroAdapter.setOnItemClickCallback(new ListHeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hero data) {
                showSelectedHero(data);
            }
        });
    }
}
