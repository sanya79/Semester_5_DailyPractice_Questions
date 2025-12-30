import java.util.*;

class Solution {
    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {

        Map<String, Map<String, Double>> graph1 = buildGraph(pairs1, rates1);
        Map<String, Double> afterDay1 = computeMax(graph1, initialCurrency);

        Map<String, Map<String, Double>> graph2 = buildGraph(pairs2, rates2);
        Map<String, Double> afterDay2 = computeMax(graph2, afterDay1);

        return afterDay2.getOrDefault(initialCurrency, 1.0);
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> pairs, double[] rates) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < pairs.size(); i++) {
            String from = pairs.get(i).get(0);
            String to = pairs.get(i).get(1);
            double rate = rates[i];

            graph.putIfAbsent(from, new HashMap<>());
            graph.putIfAbsent(to, new HashMap<>());

            graph.get(from).put(to, rate);
            graph.get(to).put(from, 1.0 / rate);
        }

        return graph;
    }

    private Map<String, Double> computeMax(Map<String, Map<String, Double>> graph, String start) {
        Map<String, Double> amount = new HashMap<>();
        amount.put(start, 1.0);
        relax(graph, amount);
        return amount;
    }

    private Map<String, Double> computeMax(Map<String, Map<String, Double>> graph, Map<String, Double> start) {
        Map<String, Double> amount = new HashMap<>(start);
        relax(graph, amount);
        return amount;
    }

    private void relax(Map<String, Map<String, Double>> graph, Map<String, Double> amount) {
        int n = graph.size();

        for (int i = 0; i < n; i++) {
            for (String u : graph.keySet()) {
                if (!amount.containsKey(u)) continue;

                double curr = amount.get(u);
                for (Map.Entry<String, Double> entry : graph.get(u).entrySet()) {
                    String v = entry.getKey();
                    double rate = entry.getValue();

                    double candidate = curr * rate;
                    if (candidate > amount.getOrDefault(v, 0.0)) {
                        amount.put(v, candidate);
                    }
                }
            }
        }
    }
}
