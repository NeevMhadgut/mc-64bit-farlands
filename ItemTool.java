public class ItemTool extends Item {
   private Block[] c;
   protected float a = 4.0F;
   private int bV;
   protected uk b;

   protected ItemTool(int par1, int par2, uk par3EnumToolMaterial, Block[] par4ArrayOfBlock) {
      super(par1);
      this.b = par3EnumToolMaterial;
      this.c = par4ArrayOfBlock;
      this.bR = 1;
      this.g(par3EnumToolMaterial.a());
      this.a = par3EnumToolMaterial.b();
      this.bV = par2 + par3EnumToolMaterial.c();
   }

   @Override
   public float a(ItemStack par1ItemStack, Block par2Block) {
      for (int i = 0; i < this.c.length; i++) {
         if (this.c[i] == par2Block) {
            return this.a;
         }
      }

      return 1.0F;
   }

   @Override
   public boolean a(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving) {
      par1ItemStack.a(2, par3EntityLiving);
      return true;
   }

   @Override
   public boolean onBlockDestroyed(ItemStack par1ItemStack, int par2, long par3, int par4, long par5, EntityLiving par6EntityLiving) {
      par1ItemStack.a(1, par6EntityLiving);
      return true;
   }

   @Override
   public int a(Entity par1Entity) {
      return this.bV;
   }

   @Override
   public boolean a() {
      return true;
   }

   @Override
   public int b() {
      return this.b.e();
   }
}
