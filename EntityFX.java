public class EntityFX extends Entity {
   private int a;
   protected float b;
   protected float c;
   protected int d = 0;
   protected int e = 0;
   protected float NoiseGeneratorPerlin;
   protected float MapGenVillage;
   protected float GenLayerHills;
   protected float ap;
   protected float aq;
   public static double ar;
   public static double as;
   public static double at;

   public EntityFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
      super(par1World);
      this.a(0.2F, 0.2F);
      this.H = this.J / 2.0F;
      this.d(par2, par4, par6);
      this.GenLayerHills = this.ap = this.aq = 1.0F;
      this.r = par8 + (float)(Math.random() * 2.0 - 1.0) * 0.4F;
      this.s = par10 + (float)(Math.random() * 2.0 - 1.0) * 0.4F;
      this.t = par12 + (float)(Math.random() * 2.0 - 1.0) * 0.4F;
      float f = (float)(Math.random() + Math.random() + 1.0) * 0.15F;
      float f1 = MathHelper.a(this.r * this.r + this.s * this.s + this.t * this.t);
      this.r = this.r / f1 * f * 0.4F;
      this.s = this.s / f1 * f * 0.4F + 0.1F;
      this.t = this.t / f1 * f * 0.4F;
      this.b = this.U.nextFloat() * 3.0F;
      this.c = this.U.nextFloat() * 3.0F;
      this.NoiseGeneratorPerlin = (this.U.nextFloat() * 0.5F + 0.5F) * 2.0F;
      this.e = (int)(4.0F / (this.U.nextFloat() * 0.9F + 0.1F));
      this.d = 0;
   }

   public EntityFX c(float par1) {
      this.r *= par1;
      this.s = (this.s - 0.1F) * par1 + 0.1F;
      this.t *= par1;
      return this;
   }

   public EntityFX d(float par1) {
      this.a(0.2F * par1, 0.2F * par1);
      this.NoiseGeneratorPerlin *= par1;
      return this;
   }

   public void b(float par1, float par2, float par3) {
      this.GenLayerHills = par1;
      this.ap = par2;
      this.aq = par3;
   }

   public float o() {
      return this.GenLayerHills;
   }

   public float p() {
      return this.ap;
   }

   public float r() {
      return this.aq;
   }

   @Override
   protected boolean e_() {
      return false;
   }

   @Override
   protected void b() {
   }

   @Override
   public void J_() {
      this.l = this.o;
      this.m = this.p;
      this.n = this.q;
      if (this.d++ >= this.e) {
         this.A();
      }

      this.s = this.s - 0.04 * this.MapGenVillage;
      this.b(this.r, this.s, this.t);
      this.r *= 0.98F;
      this.s *= 0.98F;
      this.t *= 0.98F;
      if (this.z) {
         this.r *= 0.7F;
         this.t *= 0.7F;
      }
   }

   public void renderParticle(Tessellator par1Tessellator, double par2, double par3, double par4, double par5, double par6, double par7) {
      double f = this.a % 16 / 16.0F;
      double f1 = f + 0.0624375;
      double f2 = this.a / 16 / 16.0F;
      double f3 = f2 + 0.0624375;
      double f4 = 0.1 * this.NoiseGeneratorPerlin;
      double f5 = this.l + (this.o - this.l) * par2 - ar;
      double f6 = this.m + (this.p - this.m) * par2 - as;
      double f7 = this.n + (this.q - this.n) * par2 - at;
      float f8 = 1.0F;
      par1Tessellator.a(this.GenLayerHills * f8, this.ap * f8, this.aq * f8);
      par1Tessellator.a(f5 - par3 * f4 - par6 * f4, f6 - par4 * f4, f7 - par5 * f4 - par7 * f4, f1, f3);
      par1Tessellator.a(f5 - par3 * f4 + par6 * f4, f6 + par4 * f4, f7 - par5 * f4 + par7 * f4, f1, f2);
      par1Tessellator.a(f5 + par3 * f4 + par6 * f4, f6 + par4 * f4, f7 + par5 * f4 + par7 * f4, f, f2);
      par1Tessellator.a(f5 + par3 * f4 - par6 * f4, f6 - par4 * f4, f7 + par5 * f4 - par7 * f4, f, f3);
   }

   public int n() {
      return 0;
   }

   @Override
   public void b(ady nbttagcompound) {
   }

   @Override
   public void a(ady nbttagcompound) {
   }

   public void c(int par1) {
      this.a = par1;
   }

   public int s() {
      return this.a;
   }

   @Override
   public boolean k_() {
      return false;
   }
}
