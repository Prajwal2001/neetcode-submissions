class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s: strs) {
            for (char c: s.toCharArray()) {
                sb.append(-(int) c);
            }
            sb.append(-((int)Character.MAX_VALUE + 1));
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        
        StringBuilder ele = new StringBuilder();
        for (String s: str.split("-")) {
            if (s.isEmpty()) {
                continue;
            }
            int num = Integer.parseInt(s);
            if (num <= Character.MAX_VALUE) {
                ele.append((char) num);
            } else {
                list.add(ele.toString());
                ele = new StringBuilder();
            }
        }

        return list;
    }
}
