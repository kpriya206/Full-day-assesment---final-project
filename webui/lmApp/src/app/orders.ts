export class Orders {
   
    public ordId : number;
    public cusId : number;
    public foodId : string;
    public ordQty : number;
    public ordTotalCost : number;
    public ordDate : number;
    public ordStatus : string = 'ORDERED';
    public venId : number;
    public couponCode : string;
    public tokenNo : number;
    constructor( )
{ }
}
