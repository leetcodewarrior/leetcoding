class LC399EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        
        // Graph Building.
        graphBuilder(graph, equations, values);
        // Queries Iteration.
        double[] result = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            HashSet<String> visited = new HashSet<>();
            String numberator = queries.get(i).get(0);
            String denominator = queries.get(i).get(1);
            result[i] = makeQuery(graph, numberator, denominator, visited);
        }
        // return.
        return result;
    }
    
    private double makeQuery(HashMap<String, HashMap<String, Double>> graph, String numberator, String denominator, HashSet<String> visited){
        if(!graph.containsKey(numberator) || !graph.containsKey(denominator)){
            return -1.0;
        }
        if(numberator.equals(denominator)){
            return 1.0;
        }
        visited.add(numberator);
        HashMap<String, Double> subgraph = graph.get(numberator);
        double result = -1.0;
        if(subgraph.containsKey(denominator)){
            result = subgraph.get(denominator);
        }else{
            for(Map.Entry<String, Double> entry: subgraph.entrySet()){
                String nextNumberator = entry.getKey();
                Double quotient = entry.getValue();
                
                if(visited.contains(nextNumberator)){
                    continue;
                }
                
                double output = makeQuery(graph, nextNumberator, denominator, visited);
                if(output != -1.0){
                    result = quotient * output;
                    break;
                }
            }
        }
        visited.remove(numberator);
        return result;
    }
    
    private void graphBuilder(HashMap<String, HashMap<String, Double>> graph, List<List<String>> equations, double[] values){
        for(int i = 0; i < values.length; i++){
            String numberator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);
            double quotient = values[i];
            
            if(!graph.containsKey(numberator)){
                graph.put(numberator, new HashMap<>());
            }
            if(!graph.containsKey(denominator)){
                graph.put(denominator, new HashMap<>());
            }
            
            graph.get(numberator).put(denominator, quotient);
            graph.get(denominator).put(numberator, 1.0 / quotient);
            
        }
    }
}
