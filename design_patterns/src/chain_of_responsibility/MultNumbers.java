package chain_of_responsibility;

class MultNumbers implements Chain{

    private  Chain nextInChain;

    public void setNextChain(Chain nextChain) {

        nextInChain = nextChain;
    }

    public void calculate(Numbers request) {

        if(request.getCalcWanted().equals("mult"))

            System.out.print(request.getNumber1() + " * " + request.getNumber2() + " = "+
                    (request.getNumber1()*request.getNumber2()));
        else
            nextInChain.calculate(request);
    }
}
