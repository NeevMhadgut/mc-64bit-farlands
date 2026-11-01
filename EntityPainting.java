import java.util.ArrayList;
import java.util.List;

public class EntityPainting extends Entity {
   private int NoiseGeneratorPerlin = 0;
   public int a = 0;
   public long b;
   public int c;
   public long d;
   public go e;

   public EntityPainting(World par1World) {
      super(par1World);
      this.H = 0.0F;
      this.e = go.a;
      this.a(0.5F, 0.5F);
   }

   public EntityPainting(World par1World, long par2, int par3, long par4, int par5) {
      this(par1World);
      this.b = par2;
      this.c = par3;
      this.d = par4;
      ArrayList arraylist = new ArrayList();

      for (go enumart : go.values()) {
         this.e = enumart;
         this.b(par5);
         if (this.n()) {
            arraylist.add(enumart);
         }
      }

      if (arraylist.size() > 0) {
         this.e = (go)arraylist.get(this.U.nextInt(arraylist.size()));
      }

      this.b(par5);
   }

   public EntityPainting(World par1World, long par2, int par3, long par4, int par5, String par6Str) {
      this(par1World);
      this.b = par2;
      this.c = par3;
      this.d = par4;

      for (go enumart : go.values()) {
         if (enumart.A.equals(par6Str)) {
            this.e = enumart;
            break;
         }
      }

      this.b(par5);
   }

   @Override
   protected void b() {
   }

   public void b(int par1) {
      this.a = par1;
      this.w = this.u = par1 * 90;
      float f = this.e.B;
      float f1 = this.e.C;
      float f2 = this.e.B;
      if (par1 != 0 && par1 != 2) {
         f = 0.5F;
      } else {
         f2 = 0.5F;
      }

      f /= 32.0F;
      f1 /= 32.0F;
      f2 /= 32.0F;
      double f3 = this.b + 0.5;
      double f4 = this.c + 0.5;
      double f5 = this.d + 0.5;
      float f6 = 0.5625F;
      if (par1 == 0) {
         f5 -= f6;
      }

      if (par1 == 1) {
         f3 -= f6;
      }

      if (par1 == 2) {
         f5 += f6;
      }

      if (par1 == 3) {
         f3 += f6;
      }

      if (par1 == 0) {
         f3 -= this.c(this.e.B);
      }

      if (par1 == 1) {
         f5 += this.c(this.e.B);
      }

      if (par1 == 2) {
         f3 += this.c(this.e.B);
      }

      if (par1 == 3) {
         f5 -= this.c(this.e.B);
      }

      f4 += this.c(this.e.C);
      this.d(f3, f4, f5);
      float f7 = -0.00625F;
      this.y.c(f3 - f - f7, f4 - f1 - f7, f5 - f2 - f7, f3 + f + f7, f4 + f1 + f7, f5 + f2 + f7);
   }

   private float c(int par1) {
      if (par1 == 32) {
         return 0.5F;
      } else {
         return par1 != 64 ? 0.0F : 0.5F;
      }
   }

   @Override
   public void J_() {
      if (this.NoiseGeneratorPerlin++ == 100 && !this.k.F) {
         this.NoiseGeneratorPerlin = 0;
         if (!this.G && !this.n()) {
            this.A();
            this.k.a(new EntityItem(this.k, this.o, this.p, this.q, new ItemStack(Item.as)));
         }
      }
   }

   public boolean n() {
      if (this.k.a(this, this.y).size() > 0) {
         return false;
      }

      int i = this.e.B / 16;
      int j = this.e.C / 16;
      long k = this.b;
      int l = this.c;
      long i1 = this.d;
      if (this.a == 0) {
         k = MathHelper.d(this.o - this.e.B / 32.0F);
      }

      if (this.a == 1) {
         i1 = MathHelper.d(this.q - this.e.B / 32.0F);
      }

      if (this.a == 2) {
         k = MathHelper.d(this.o - this.e.B / 32.0F);
      }

      if (this.a == 3) {
         i1 = MathHelper.d(this.q - this.e.B / 32.0F);
      }

      l = MathHelper.c(this.p - this.e.C / 32.0F);

      for (int j1 = 0; j1 < i; j1++) {
         for (int k1 = 0; k1 < j; k1++) {
            acn material;
            if (this.a != 0 && this.a != 2) {
               material = this.k.getBlockMaterial(this.b, l + k1, i1 + j1);
            } else {
               material = this.k.getBlockMaterial(k + j1, l + k1, this.d);
            }

            if (!material.a()) {
               return false;
            }
         }
      }

      List list = this.k.b(this, this.y);

      for (int l1 = 0; l1 < list.size(); l1++) {
         if (list.get(l1) instanceof EntityPainting) {
            return false;
         }
      }

      return true;
   }

   @Override
   public boolean l_() {
      return true;
   }

   @Override
   public boolean a(md par1DamageSource, int par2) {
      if (!this.G && !this.k.F) {
         this.A();
         this.K();
         this.k.a(new EntityItem(this.k, this.o, this.p, this.q, new ItemStack(Item.as)));
      }

      return true;
   }

   @Override
   public void b(ady par1NBTTagCompound) {
      par1NBTTagCompound.a("Dir", (byte)this.a);
      par1NBTTagCompound.a("Motive", this.e.A);
      par1NBTTagCompound.a("TileX", this.b);
      par1NBTTagCompound.a("TileY", this.c);
      par1NBTTagCompound.a("TileZ", this.d);
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      this.a = par1NBTTagCompound.d("Dir");

      try {
         this.b = par1NBTTagCompound.g("TileX");
      } catch (ClassCastException ex) {
         this.b = par1NBTTagCompound.f("TileX");
      }

      this.c = par1NBTTagCompound.f("TileY");

      try {
         this.d = par1NBTTagCompound.g("TileZ");
      } catch (ClassCastException ex) {
         this.d = par1NBTTagCompound.f("TileZ");
      }

      String s = par1NBTTagCompound.j("Motive");

      for (go enumart : go.values()) {
         if (enumart.A.equals(s)) {
            this.e = enumart;
         }
      }

      if (this.e == null) {
         this.e = go.a;
      }

      this.b(this.a);
   }

   @Override
   public void b(double par1, double par3, double par5) {
      if (!this.k.F && !this.G && par1 * par1 + par3 * par3 + par5 * par5 > 0.0) {
         this.A();
         this.k.a(new EntityItem(this.k, this.o, this.p, this.q, new ItemStack(Item.as)));
      }
   }

   @Override
   public void c(double par1, double par3, double par5) {
      if (!this.k.F && !this.G && par1 * par1 + par3 * par3 + par5 * par5 > 0.0) {
         this.A();
         this.k.a(new EntityItem(this.k, this.o, this.p, this.q, new ItemStack(Item.as)));
      }
   }
}
