package primitives;

public class Material {
    private double _Kd; // Diffusion attenuation coefficient
    private double _Ks; // Specular attenuation coefficient
    private double _Kr; // Reflection coefficient (1 for mirror)
    private double _Kt; // Refraction coefficient (1 for transparent)
    //private double _n; // Refraction index
    private int _nShininess; // Sheen coefficient

    // ***************** Constructors ********************** //
    public Material()
    {
        _Kd = 1;
        _Ks = 1;
        _Kr = 0.3;
        _Kt = 0;
//        _n = 1;
        _nShininess = 19;
    }
    public Material(Material material){
        _Kd = material.getKd();
        _Ks = material.getKs();
        _Kr = material.getKr();
        _Kt = material.getKt();
//        _n = material.getN();
        _nShininess = material.getShininess();
    }



    // ***************** Getters/Setters ********************** //

    public double getKd() {
        return _Kd;
    }

    public void setKd(double _Kd) {
        this._Kd = _Kd;
    }

    public double getKs() {
        return _Ks;
    }

    public void setKs(double _Ks) {
        this._Ks = _Ks;
    }

    public double getKr() {
        return _Kr;
    }

    public void setKr(double _Kr) {
        this._Kr = _Kr;
    }

    public double getKt() {
        return _Kt;
    }

    public void setKt(double _Kt) {
        this._Kt = _Kt;
    }

//    public double getN() {
//        return _n;
//    }
//
//    public void setN(double _n) {
//        this._n = _n;
//    }

    public int getShininess() { return _nShininess;  }

    public void setShininess(int _nShininess){this._nShininess = _nShininess;}
}
