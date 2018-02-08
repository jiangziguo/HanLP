package com.hankcs.demo;

import com.hankcs.hanlp.mining.word2vec.KMeansClustering;
import com.hankcs.hanlp.mining.word2vec.VectorsReader;

/**
 * Created by lenovo on 2018/2/7.
 */
public class KMeansCluster {
    private static final String VECTOR_FILE = "data/test/word2vec_ika.txt";
    private static final int CLUSTER_NUM = 100;
    private static final String CLUSTER_OUT_FILE = "data/test/cluster_ika_100.txt";

    public static void main(String[] args) throws Exception{
        final VectorsReader vectorsReader = new VectorsReader(VECTOR_FILE);
        vectorsReader.readVectorFile();

        KMeansClustering kmc = new KMeansClustering(vectorsReader, CLUSTER_NUM, CLUSTER_OUT_FILE);
        kmc.clustering();
    }
}
