public class ItemSword extends Item {
   private int a;
   private final uk b;

   public ItemSword(int par1, uk par2EnumToolMaterial) {
      super(par1);
      this.b = par2EnumToolMaterial;
      this.bR = 1;
      this.g(par2EnumToolMaterial.a());
      this.a = 4 + par2EnumToolMaterial.c();
   }

   @Override
   public float a(ItemStack par1ItemStack, Block par2Block) {
      return par2Block.bO != Block.W.bO ? 1.5F : 15.0F;
   }

   @Override
   public boolean a(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving) {
      par1ItemStack.a(1, par3EntityLiving);
      return true;
   }

   @Override
   public boolean onBlockDestroyed(ItemStack par1ItemStack, int par2, long par3, int par4, long par5, EntityLiving par6EntityLiving) {
      par1ItemStack.a(2, par6EntityLiving);
      return true;
   }

   @Override
   public int a(Entity par1Entity) {
      return this.a;
   }

   @Override
   public boolean a() {
      return true;
   }

   @Override
   public aaq c(ItemStack par1ItemStack) {
      return aaq.d;
   }

   @Override
   public int b(ItemStack par1ItemStack) {
      return 72000;
   }

   @Override
   public ItemStack a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      par3EntityPlayer.c(par1ItemStack, this.b(par1ItemStack));
      return par1ItemStack;
   }

   @Override
   public boolean a(Block par1Block) {
      return par1Block.bO == Block.W.bO;
   }

   @Override
   public int b() {
      return this.b.e();
   }
}
