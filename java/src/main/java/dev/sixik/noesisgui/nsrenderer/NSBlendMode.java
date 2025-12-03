package dev.sixik.noesisgui.nsrenderer;

public enum NSBlendMode {

    //  ----------------------------------------------------
    //  COLOR                       ALPHA
    //  ----------------------------------------------------
    Src,                     //  cs                          as
    SrcOver,                 //  cs + cd * (1 - as)          as + ad * (1 - as)
    SrcOver_Multiply,        //  cs * cd + cd * (1 - as)     as + ad * (1 - as)
    SrcOver_Screen,          //  cs + cd * (1 - cs)          as + ad * (1 - as)
    SrcOver_Additive,        //  cs + cs                     as + ad * (1 - as)
    SrcOver_Dual,            //  cs + cd * (1 - as) [RGB]    as + ad * (1 - as) [RGB]
    //  ----------------------------------------------------

    Count
}
