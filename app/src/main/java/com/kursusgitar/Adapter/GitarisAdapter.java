package com.kursusgitar.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kursusgitar.Model.Gitaris;
import com.kursusgitar.R;

import java.util.List;

public class GitarisAdapter  extends  RecyclerView.Adapter<GitarisAdapter.GitarisViewHolder>{
    List<Gitaris> listGitaris;

    public class GitarisViewHolder extends RecyclerView.ViewHolder{
        public TextView listNamaGitaris, listAlamat, listUmur,listTingkat;
        public View itemVIew;

        public GitarisViewHolder (@NonNull View itemVIew){
            super(itemVIew);

            listNamaGitaris = itemVIew.findViewById(R.id.listNamaGitaris);
            listAlamat= itemVIew.findViewById(R.id.listAlamat);
            listUmur = itemVIew.findViewById(R.id.listUmur);
            listTingkat= itemVIew.findViewById(R.id.listTingkat);
        }
    }

    public GitarisAdapter(List<Gitaris> listGitaris){
        this.listGitaris = listGitaris;
    }


        @NonNull
        @Override
        public GitarisAdapter.GitarisViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_gitaris,viewGroup,false);
            GitarisViewHolder gitarisViewHolder = new GitarisViewHolder(mView);
            return gitarisViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull final GitarisAdapter.GitarisViewHolder viewHolder, int i) {

            viewHolder.listNamaGitaris.setText(listGitaris.get(i).getNama_gitaris());
            viewHolder.listAlamat.setText(listGitaris.get(i).getAlamat());
            viewHolder.listUmur.setText(listGitaris.get(i).getUmur());
            viewHolder.listTingkat.setText(listGitaris.get(i).getTingkat());
            viewHolder.itemVIew.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(viewHolder.itemView.getContext(), "clicked on Row ", Toast.LENGTH_SHORT);
                }
            });
        }
                @Override
                public int getItemCount() {
                    return listGitaris.size();
                }

            }




