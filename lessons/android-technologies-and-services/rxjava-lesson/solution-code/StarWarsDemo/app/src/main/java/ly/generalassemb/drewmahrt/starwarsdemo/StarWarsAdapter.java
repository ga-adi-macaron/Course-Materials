package ly.generalassemb.drewmahrt.starwarsdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StarWarsAdapter extends RecyclerView.Adapter<StarWarsAdapter.CharacterViewHolder> {
    List<SWCharacter> mCharacters;

    public StarWarsAdapter(List<SWCharacter> characters) {
        super();
        mCharacters = characters;
    }

    public void addData(SWCharacter character) {
        mCharacters.add(character);
        notifyItemInserted(mCharacters.size()-1);
    }

    public void clear() {
        mCharacters.clear();
        notifyDataSetChanged();
    }

    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_item, viewGroup, false);
        CharacterViewHolder viewHolder = new CharacterViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CharacterViewHolder viewHolder, int i) {
        SWCharacter character = mCharacters.get(i);
        viewHolder.mName.setText(character.getName());
        viewHolder.mHeight.setText("Height: " + character.getHeight());
        viewHolder.mBirthYear.setText("Birth Year: " + character.getBirthYear());
    }

    @Override
    public int getItemCount() {
        return mCharacters.size();
    }

    class CharacterViewHolder extends RecyclerView.ViewHolder {
        public TextView mName;
        public TextView mHeight;
        public TextView mBirthYear;

        public CharacterViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.name);
            mHeight = (TextView) itemView.findViewById(R.id.height);
            mBirthYear = (TextView) itemView.findViewById(R.id.birth_year);
        }
    }
}