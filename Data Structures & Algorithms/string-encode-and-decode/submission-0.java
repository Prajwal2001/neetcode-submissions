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
        
        String ele = "";
        for (String s: str.split("-")) {
            if (s.isEmpty()) {
                continue;
            }
            int num = Integer.parseInt(s);
            if (num <= Character.MAX_VALUE) {
                ele += String.valueOf((char) num);
            } else {
                list.add(ele);
                ele = "";
            }
        }

        return list;
    }
}
