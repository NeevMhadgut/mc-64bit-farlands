import java.util.ArrayList;
import java.util.List;

public class TileEntityPiston extends TileEntity {
   private int a;
   private int b;
   private int c;
   private boolean d;
   private boolean e;
   private float f;
   private float g;
   private static List h = new ArrayList();

   public TileEntityPiston() {
   }

   public TileEntityPiston(int par1, int par2, int par3, boolean par4, boolean par5) {
      this.a = par1;
      this.b = par2;
      this.c = par3;
      this.d = par4;
      this.e = par5;
   }

   public int a() {
      return this.a;
   }

   @Override
   public int i() {
      return this.b;
   }

   public boolean d() {
      return this.d;
   }

   public int e() {
      return this.c;
   }

   public boolean f() {
      return this.e;
   }

   public float a(float par1) {
      if (par1 > 1.0F) {
         par1 = 1.0F;
      }

      return this.g + (this.f - this.g) * par1;
   }

   public float b(float par1) {
      return this.d ? (this.a(par1) - 1.0F) * qs.b[this.c] : (1.0F - this.a(par1)) * qs.b[this.c];
   }

   public float c(float par1) {
      return this.d ? (this.a(par1) - 1.0F) * qs.c[this.c] : (1.0F - this.a(par1)) * qs.c[this.c];
   }

   public float d(float par1) {
      return this.d ? (this.a(par1) - 1.0F) * qs.d[this.c] : (1.0F - this.a(par1)) * qs.d[this.c];
   }

   private void a(float par1, float par2) {
      if (!this.d) {
         par1--;
      } else {
         par1 = 1.0F - par1;
      }

      AxisAlignedBB axisalignedbb = Block.EntityNoteFX.getAxisAlignedBB(this.i, this.j, this.k, this.l, this.a, par1, this.c);
      if (axisalignedbb != null) {
         List list = this.i.b(null, axisalignedbb);
         if (!list.isEmpty()) {
            h.addAll(list);

            for (Entity entity : h) {
               entity.b((double)par2 * qs.b[this.c], (double)par2 * qs.c[this.c], (double)par2 * qs.d[this.c]);
            }

            h.clear();
         }
      }
   }

   public void g() {
      if (this.g < 1.0F && this.i != null) {
         this.g = this.f = 1.0F;
         this.i.removeBlockTileEntity(this.j, this.k, this.l);
         this.h();
         if (this.i.getBlockId(this.j, this.k, this.l) == Block.EntityNoteFX.bO) {
            this.i.setBlockAndMetadataWithNotify(this.j, this.k, this.l, this.a, this.b);
         }
      }
   }

   @Override
   public void n_() {
      this.g = this.f;
      if (this.g >= 1.0F) {
         this.a(1.0F, 0.25F);
         this.i.removeBlockTileEntity(this.j, this.k, this.l);
         this.h();
         if (this.i.getBlockId(this.j, this.k, this.l) == Block.EntityNoteFX.bO) {
            this.i.setBlockAndMetadataWithNotify(this.j, this.k, this.l, this.a, this.b);
         }
      } else {
         this.f += 0.5F;
         if (this.f >= 1.0F) {
            this.f = 1.0F;
         }

         if (this.d) {
            this.a(this.f, this.f - this.g + 0.0625F);
         }
      }
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      super.a(par1NBTTagCompound);
      this.a = par1NBTTagCompound.f("blockId");
      this.b = par1NBTTagCompound.f("blockData");
      this.c = par1NBTTagCompound.f("facing");
      this.g = this.f = par1NBTTagCompound.h("progress");
      this.d = par1NBTTagCompound.o("extending");
   }

   @Override
   public void b(ady par1NBTTagCompound) {
      super.b(par1NBTTagCompound);
      par1NBTTagCompound.a("blockId", this.a);
      par1NBTTagCompound.a("blockData", this.b);
      par1NBTTagCompound.a("facing", this.c);
      par1NBTTagCompound.a("progress", this.g);
      par1NBTTagCompound.a("extending", this.d);
   }
}
