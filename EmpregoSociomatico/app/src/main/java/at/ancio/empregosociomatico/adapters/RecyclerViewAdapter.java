package at.ancio.empregosociomatico.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import at.ancio.empregosociomatico.R;
import at.ancio.empregosociomatico.activities.VagasActivity;
import at.ancio.empregosociomatico.models.Vagas;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
private Context mContext;
private List<Vagas>mData;
RequestOptions option;


    public RecyclerViewAdapter(Context mContext, List<Vagas> mData) {
         this.mContext = mContext;
         this.mData = mData;
         option = new RequestOptions().centerCrop().placeholder(R.drawable.load).error(R.drawable.load);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.vagas_row_item,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
           viewHolder.view_container.setOnClickListener(new View.OnClickListener(){


               @Override
               public void onClick(View v) {
                   Intent i = new Intent(mContext, VagasActivity.class);
                   i.putExtra( name "Vagas_name",mData.get(viewHolder.getAdapterPosition()).getNome());
                   i.putExtra( name "Vagas_Empresa",mData.get(viewHolder.getAdapterPosition()).getEmpresa());
                   i.putExtra( name "Vagas_Disponibilidade",mData.get(viewHolder.getAdapterPosition()).getDisponibilidade());
                   i.putExtra( name "Vagas_Data",mData.get(viewHolder.getAdapterPosition()).getData());
                   i.putExtra( name "Vagas_Descricao",mData.get(viewHolder.getAdapterPosition()).getDescription());
                   i.putExtra( name "Vagas_imagem",mData.get(viewHolder.getAdapterPosition()).getImage());

              mContext.startActivity(i);
               }
           });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.vagas_nome.setText(mData.get(position).getNome());
        viewHolder.vagas_empresa.setText(mData.get(position).getEmpresa());
        viewHolder.vagas_disponibilidade.setText(mData.get(position).getDisponibilidade());

        Glide.with(mContext).load(mData.get(position).getImage()).apply(option).into(viewHolder.img_thumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView vagas_nome;
        TextView vagas_empresa;
        TextView vagas_disponibilidade;
        ImageView img_thumbnail;
        LinearLayout view_container;

        public ViewHolder(View itemView) {
            super(itemView);
            view_container = itemView.findViewById(R.id.container);
            vagas_nome= itemView.findViewById(R.id.vaga_nome);
            vagas_empresa = itemView.findViewById(R.id.Empresa);
            vagas_disponibilidade = itemView.findViewById(R.id.Disponibilidade);
            img_thumbnail = itemView.findViewById(R.id.imageView);
        }
    }
}