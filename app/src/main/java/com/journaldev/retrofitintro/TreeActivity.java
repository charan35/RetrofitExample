package com.journaldev.retrofitintro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import de.blox.graphview.Graph;
import de.blox.graphview.GraphAdapter;
import de.blox.graphview.GraphView;
import de.blox.graphview.Node;
import de.blox.graphview.tree.BuchheimWalkerAlgorithm;
import de.blox.graphview.tree.BuchheimWalkerConfiguration;

public class TreeActivity extends AppCompatActivity {

    private int nodeCount = 1;
    private Node currentNode;
    protected GraphView graphView;
    protected GraphAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);

        final Graph graph = createGraph();
        setupAdapter(graph);
        setupToolbar();


    }

    private void setupAdapter(Graph graph) {
        graphView = findViewById(R.id.graph);
        setLayout(graphView);
        adapter = new GraphAdapter<GraphView.ViewHolder>(graph) {

            @Override
            public int getCount() {
                return graph.getNodeCount();
            }

            @Override
            public Object getItem(int position) {
                return graph.getNodeAtPosition(position);
            }

            @Override
            public boolean isEmpty() {
                return graph.hasNodes();
            }

            @NonNull
            @Override
            public GraphView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.node, parent, false);
                return new SimpleViewHolder(view);
            }

            @Override
            public void onBindViewHolder(GraphView.ViewHolder viewHolder, Object data, int position) {
                ((SimpleViewHolder) viewHolder).textView.setText(data.toString());
            }

            class SimpleViewHolder extends GraphView.ViewHolder {
                TextView textView;

                SimpleViewHolder(View itemView) {
                    super(itemView);
                    textView = itemView.findViewById(R.id.textView);
                }
            }
        };
        graphView.setAdapter(adapter);
        graphView.setOnItemClickListener((parent, view, position, id) -> {
            currentNode = (Node) adapter.getItem(position);
            Snackbar.make(graphView, "Clicked on " + currentNode.getData().toString(), Snackbar.LENGTH_SHORT).show();
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }



    private void setupToolbar() {
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.back);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    public Graph createGraph() {
        final Graph graph = new Graph();
        final Node node1 = new Node(getNodeText());
        final Node node2 = new Node(getNodeText());
        final Node node3 = new Node(getNodeText());
        final Node node4 = new Node(getNodeText());
        final Node node5 = new Node(getNodeText());
        final Node node6 = new Node(getNodeText());
        final Node node8 = new Node(getNodeText());
        final Node node7 = new Node(getNodeText());
        final Node node9 = new Node(getNodeText());
        final Node node10 = new Node(getNodeText());
        final Node node11 = new Node(getNodeText());
        final Node node12 = new Node(getNodeText());

        graph.addEdge(node1, node2);
        graph.addEdge(node1, node3);
        graph.addEdge(node1, node4);
        graph.addEdge(node2, node5);
        graph.addEdge(node2, node6);
        graph.addEdge(node6, node7);
        graph.addEdge(node6, node8);
        graph.addEdge(node4, node9);
        graph.addEdge(node4, node10);
        graph.addEdge(node4, node11);
        graph.addEdge(node11, node12);

        return graph;
    }

    public void setLayout(GraphView view) {
        final BuchheimWalkerConfiguration configuration = new BuchheimWalkerConfiguration.Builder()
                .setSiblingSeparation(100)
                .setLevelSeparation(300)
                .setSubtreeSeparation(300)
                .setOrientation(BuchheimWalkerConfiguration.ORIENTATION_TOP_BOTTOM)
                .build();
        view.setLayout(new BuchheimWalkerAlgorithm(configuration));
    }

    protected String getNodeText() {
        return "Node " + nodeCount++;
    }


}