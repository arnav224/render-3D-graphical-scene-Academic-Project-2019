package primitives;

public class Material {
    private double _Kd; // Diffusion attenuation coefficient
    private double _Ks; // Specular attenuation coefficient
    private double _Kr; // Reflection coefficient (1 for mirror)
    private double _Kt; // Refraction coefficient (1 for transparent)
    //private double _n; // Refraction index
    private int _nShininess; // Sheen coefficient
    private double _blurring;
    private int _NumOfReflectionRays;

    // ***************** Constructors ********************** //
    public Material()
    {
        _Kd = 1;
        _Ks = 1;
        _Kr = 0;
        _Kt = 0;
        _nShininess = 19;
        _blurring = 0;
        _NumOfReflectionRays = 0;
    }
    public Material(Material material){
        _Kd = material.getKd();
        _Ks = material.getKs();
        _Kr = material.getKr();
        _Kt = material.getKt();
//        _n = material.getN();
        _blurring = material.getBlurring();
        _nShininess = material.getShininess();
        _NumOfReflectionRays = material._NumOfReflectionRays;
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

    public void setKr(double _Kr) throws Exception{
        if (this._Kt + _Kr > 1)
            throw new Exception("(Kt + Kr) should be less than 1");
        this._Kr = _Kr;
    }

    public double getKt() {
        return _Kt;
    }

    public void setKt(double _Kt) throws Exception{
        if (this._Kr + _Kt > 1)
            throw new Exception("(Kt + Kr) should be less than 1");
        this._Kt = _Kt;
    }

    public double getBlurring() {
        return _blurring;
    }

    public void setBlurring(double reflectionSharpness) {
        this._blurring = reflectionSharpness;
    }

    public int get_NumOfReflectionRays() {
        return _NumOfReflectionRays;
    }

    public void set_NumOfReflectionRays(int NumOfReflectionRays) {
        this._NumOfReflectionRays = NumOfReflectionRays;
    }

    public int getShininess() { return _nShininess;  }

    public void setShininess(int _nShininess){this._nShininess = _nShininess;}
}
