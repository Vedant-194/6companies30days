public String kthLargestNumber(String[] nums, int k) {
        String result = "";
        if(nums==null || nums.length==0 || k<=0){
            return result;
        }

        PriorityQueue<BigInteger> helper = new PriorityQueue<>();

        for (String i : nums){
            BigInteger number = new BigInteger(i);
            if(helper.size()< k ){
                helper.add(number);
            }else {
                if(helper.peek().compareTo(number)<0){
                    helper.poll();
                    helper.add(number);
                }
            }
        }
        return helper.poll().toString();
    }
