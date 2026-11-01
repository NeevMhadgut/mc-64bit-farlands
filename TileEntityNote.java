public class TileEntityNote extends TileEntity {
   public byte a = 0;
   public boolean b = false;

   @Override
   public void b(ady par1NBTTagCompound) {
      super.b(par1NBTTagCompound);
      par1NBTTagCompound.a("note", this.a);
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      super.a(par1NBTTagCompound);
      this.a = par1NBTTagCompound.d("note");
      if (this.a < 0) {
         this.a = 0;
      }

      if (this.a > 24) {
         this.a = 24;
      }
   }

   public void a() {
      this.a = (byte)((this.a + 1) % 25);
      this.j();
   }

   public void triggerNote(World par1World, long par2, int par3, long par4) {
      if (par1World.getBlockMaterial(par2, par3 + 1, par4) == acn.a) {
         acn material = par1World.getBlockMaterial(par2, par3 - 1, par4);
         byte byte0 = 0;
         if (material == acn.e) {
            byte0 = 1;
         }

         if (material == acn.o) {
            byte0 = 2;
         }

         if (material == acn.q) {
            byte0 = 3;
         }

         if (material == acn.d) {
            byte0 = 4;
         }

         par1World.playNoteAt(par2, par3, par4, byte0, this.a);
      }
   }
}
